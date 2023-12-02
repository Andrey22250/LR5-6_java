import java.util.Scanner;
public class Build {
    private static int number = 1;
    private int numBuild;
    private PC pc;
    private String client;
    private Status status;
    public Build()
    {
        this.pc = new PC();
        this.status = Status.CREATE;
        this.numBuild = number;

        number++;
    }
    public Build(String client)
    {
        this.pc = new PC();
        this.status = Status.CREATE;
        this.numBuild = number;
        this.client = client;

        number++;
    }
    public Build(int Stat)
    {
        this.pc = new PC();
        this.status = Status.intToStatus(Stat);
        this.numBuild = number;
        this.client = client;

        number++;
    }
    public Build(String client, PC pc, Status status)
    {
        SetBuild(client, pc, status);
        number++;
    }
    private boolean CheckCor(String client)
    {
        return !client.isEmpty();
    }
    private void SetBuild(String client, PC pc, Status status)
    {
        if (CheckCor(client))
        {
            this.pc = pc;
            this.status = status;
            this.numBuild = number;
            this.client = client;
        }
        else
        {
            System.out.println("Ошибка ввода данных!");
            System.exit(-1);
        }
    }
    public static int GetNumber() {return number;}
    public int GetNumBuild() {
        return numBuild;
    }
    public PC GetPc() {
        return pc;
    }
    public String GetClient() {
        return client;
    }
    public Status GetStatus() {
        return status;
    }
    public void input_build()
    {
        String client;
        Status status;

        Scanner in = new Scanner(System.in);

        System.out.print("Ввод данных заказа\n\n ");
        System.out.print("Введите имя клиента: ");
        client = in.nextLine();
        System.out.print("Введите статус заказа, где\n0 - Заказ создан\n1 - Заказ в работе\n2 - Заказ выполнен\nВаш выбор: ");
        status = Status.intToStatus(in.nextInt());
        System.out.print("\nВвод информации о компьютере\n");
        pc.input_pc();

        SetBuild(client, pc, status);
    }
    public void out_build()
    {
        System.out.print("\nИнформация о заказе:\n\n");
        System.out.printf("Номер заказа: %d\n", GetNumBuild());
        System.out.printf("Клиент - %s\n", GetClient());
        System.out.printf("Статус - %s\n", status.getName());
        pc.out_PC();
    }
    public void ChangeStatus(Status newstatus)
    {
        if (newstatus.compareTo(Status.CREATE) >= 0 && newstatus.compareTo(Status.FINISHED) <= 0)
        {
            this.status = newstatus;
            System.out.print("Состояние заказа успешно изменено!\n");
        }
        else {
            System.out.println("Ошибка ввода данных!");
            System.exit(-1);
        }
    }
    static class Stat
    {
        public static int GetStat(String name)
        {
            return switch (name)
            {
                case "Создан" -> 0;
                case "В сборке" -> 1;
                case "Готов к выдаче" -> 2;
                default -> throw new IllegalArgumentException("Некорректный формат данных!");
            };
        }
    }
}