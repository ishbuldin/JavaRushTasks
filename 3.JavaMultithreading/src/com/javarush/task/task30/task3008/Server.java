package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        int port = ConsoleHelper.readInt();
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                System.out.println("Сообщение не отправлено");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            Message receive;

            while (true) {

                connection.send(new Message(MessageType.NAME_REQUEST));

                receive = connection.receive();
                if (receive.getType().equals(MessageType.USER_NAME)) {
                    if (!receive.getData().isEmpty() && !connectionMap.containsKey(receive.getData())) {
                        connectionMap.put(receive.getData(), connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        return receive.getData();
                    }
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                if (!pair.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
                }
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {

                Message message = connection.receive();
                if (message.getType() == MessageType.TEXT) {
                    sendBroadcastMessage(new Message(MessageType.TEXT, userName + ": " + message.getData()));
                } else {
                    ConsoleHelper.writeMessage("Тип сообщения не TEXT");
                }
            }
        }

        @Override
        public void run() {
            ConsoleHelper.writeMessage("Установлено соединение с " + socket.getRemoteSocketAddress());
            String user = null;
            try (Connection connection = new Connection(socket)){
                user = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, user));
                sendListOfUsers(connection, user);
                serverMainLoop(connection, user);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("Возникло исключение");
            }
            finally {
                if (user != null) {
                    connectionMap.remove(user);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, user));
                }
                ConsoleHelper.writeMessage("Соединение с удалённым адресом закрыто");
            }
        }


    }
}