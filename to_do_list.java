import java.util.*;
public class to_do_list{
    static class task{
        String des;
        boolean isCompleted;
        task(String des)
        {
            this.des = des;
            this.isCompleted = false;
        }
        public void markAsCompleted()
        {
            this.isCompleted = true;
        }
        public String toString()
        {
            return (isCompleted ? "[completed]" : "[pending]")+des;
        }
    }
    static ArrayList<task> t = new ArrayList<>();
    public static void display()
    {
        if(t.isEmpty())
        {
            System.out.println("Your to do list is empty");
        }
        else{
            System.out.println("Your to do list is:");
            for(int i=0;i<t.size();i++)
            {
                System.out.println((i+1)+"."+t.get(i));
            }
        }
    }
    public static void addTask(String des)
    {
        t.add(new task(des));
        System.out.println("Your task is added.");
    }
    public static void completedtask(int taskNumber)
    {
        if(taskNumber>0 && taskNumber<=t.size())
        {
            t.get(taskNumber-1).markAsCompleted();
            System.out.println("Task marked as completed.");
        }
        else{
            System.out.println("Invalid task number.");
        }
    }
    public static void deleteTask(int taskNumber)
    {
        if(taskNumber>0 && taskNumber<=t.size())
        {
            t.remove(taskNumber-1);
            System.out.println("Task deleted successfully.");
        }
        else{
            System.out.println("Invalid task number.");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("\n To-Do List Application:");
            System.out.println("1. View Tasks");
            System.out.println("2. Add a Task");
            System.out.println("3. Completed a Task");
            System.out.println("4. Delete a Task");
            System.out.println("5. Exit");
            System.out.println("Choose an option:");
            option = sc.nextInt();
            sc.nextLine();
            switch(option)
            {
                case 1:
                    display();
                    break;
                case 2:
                    System.out.println("Enter the task description:");
                    String des = sc.nextLine();
                    addTask(des);
                    break;
                case 3:
                    display();
                    System.out.println("Enter the task number to marked as completed:");
                    int taskNumber = sc.nextInt();
                    completedtask(taskNumber);
                    break;
                case 4:
                    display();
                    System.out.println("Enter the task number to be deleted:");
                    int a = sc.nextInt();
                    deleteTask(a);
                    break;
                case 5:
                    System.out.println("Exiting the application");
                    break;
                default:
                System.out.println("Invalid option, please try later");
            }
        }while(option != 5);
        sc.close();
    }
}