package ru.zolnikov.common;

public abstract class LabBase implements IRunnable {

    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    private void loopTasks() {
        var exitRequested = false;

        listTasks();
        while (!exitRequested) {
            println("\nВведите номер задания (введите 0 для выхода):");
            var taskNum = InputValidator.readInt(true);

            exitRequested = selectTask(taskNum);
        }
    }

    protected abstract boolean selectTask(int taskNum);

    protected static void println(String output) {
        System.out.println(output);
    }

    protected static void print(String string) {
        System.out.print(string);
    }

    protected abstract void listTasks();

    protected <T> void printArray(T[] array, String delimeter) {
        for (int i = 0; i < array.length - 1; i++) {
            print(array[i].toString() + delimeter);
        }
        println(array[array.length - 1].toString());
    }

    
}
