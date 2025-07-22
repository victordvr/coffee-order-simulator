package com.victor.coffee;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReceiptManager {
    private static final String CURRENT_FILE = "current_order.txt";
    private static final String HISTORY_FILE = "history.txt";
    private static final int MAX_HISTORY = 10;

    public void saveReceipt(String receipt) {
        // save current order
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(CURRENT_FILE))) {
            writer.write(receipt);
        } catch (IOException e) {
            System.out.println("Error saving current order: " + e.getMessage());
        }

        // save history
        try {
            List<String> lines = readAllReceipts();
            lines.add(receipt);

            if (lines.size() > MAX_HISTORY) {
                lines = lines.subList(lines.size() - MAX_HISTORY, lines.size());
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(HISTORY_FILE))) {
                for (String line : lines) {
                    writer.write(line);
                    writer.newLine();
                    writer.write("-----");
                    writer.newLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving to history: " + e.getMessage());
        }
    }

    public List<String> readAllReceipts() {
        List<String> lines = new ArrayList<>();

        if (!Files.exists(Paths.get(HISTORY_FILE))) {
            return lines;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(HISTORY_FILE))) {
            StringBuilder currentReceipt = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.equals("-----")) {
                    lines.add(currentReceipt.toString());
                    currentReceipt.setLength(0);
                } else {
                    currentReceipt.append(line).append("\n");
                }
            }
            if (currentReceipt.length() > 0) {
                lines.add(currentReceipt.toString());
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return lines;
    }
}
