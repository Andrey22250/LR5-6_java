import java.lang.reflect.InvocationTargetException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main
{
    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        //5-ая лабораторная
        //1. Работа с исключениями
        try
        {
            CPU ex = new CPU("i5 9600k", 3400, 6, -12); //пробуем создать процессор с отрицательным числом ядер
        } catch (IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
        //2. Работа с двумерными и одномерными массивами
        PC[] pcs = new PC[3];
        for (int i = 0; i < 3; i++)
        {
            pcs[i] = new PC();
            pcs[i].out_PC();
        }
        CPU[][] boxOfCPUs = new CPU[2][2];
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
            {
                boxOfCPUs[i][j] = new CPU();
                System.out.printf("\n\n%s, %d, %d, %d\n", boxOfCPUs[i][j].GetName(), boxOfCPUs[i][j].GetFrequency(), boxOfCPUs[i][j].GetCores(), boxOfCPUs[i][j].GetTreads());
            }

        //6-ая лабораторная
        //1. Работа с интерфейсами и классами
        BuildComp obj = new CPU("Intel");
        System.out.println(obj);
        obj = new RAM("DDR4");
        System.out.println(obj);
        //2. Работа с шаблонами
        var build = new Build<CPU>(new CPU());
        build.input_build();
        var build2 = new Build<RAM>(new RAM());
        build2.input_build();
        //3. Глубокое и поверхностное копирование
        PC pc = new PC(65000);
        PC t = (PC)pc.clone(); //пример глубокого копирования
        pc.SetCPU(new CPU("Intel"));
        pc.out_PC();
        t.out_PC();
        t = pc; //пример поверхностного копирования
        pc.SetCPU(new CPU("AMD"));
        pc.out_PC();
        t.out_PC();
    }
}