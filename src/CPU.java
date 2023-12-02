import java.util.Scanner;
public class CPU {
    private String name_cpu;
    private int frequency;
    private int cores;
    private int treads;
    public CPU() { }
    public CPU(String name_cpu) {
        this.name_cpu = name_cpu;
    }
    public CPU(String name_cpu, int frequency, int cores, int treads) {
        SetCPU(name_cpu, frequency, cores, treads);
    }
    private boolean CheckCor(String name_cpu, int frequency, int cores, int treads)
    {
        return frequency>0 && cores > 0 && treads>0 && !name_cpu.isEmpty();
    }
    private void SetCPU(String name_cpu, int frequency, int cores, int treads)
    {
        if (CheckCor(name_cpu, frequency, cores, treads))
        {
            this.name_cpu = name_cpu;
            this.frequency = frequency;
            this.cores = cores;
            this.treads = treads;
        }
        else
        {
          System.out.println("Ошибка ввода данных!");
          System.exit(-1);
        }
    }
    public String GetName()
    {
        return name_cpu;
    }
    public int GetFrequency()
    {
        return frequency;
    }
    public int GetCores()
    {
        return cores;
    }
    public int GetTreads()
    {
        return treads;
    }

    public void input()
    {
        String name_cpu;
        int frequency, cores, treads;

        Scanner in = new Scanner(System.in);

        System.out.print("Введите название процессора: ");
        name_cpu = in.nextLine();
        System.out.print("Введите частоту процессора: ");
        frequency = in.nextInt();
        System.out.print("Введите кол-во ядер процессора: ");
        cores = in.nextInt();
        System.out.print("Введите кол-во потоков процессора: ");
        treads = in.nextInt();

        SetCPU(name_cpu, frequency, cores, treads);
    }
}
