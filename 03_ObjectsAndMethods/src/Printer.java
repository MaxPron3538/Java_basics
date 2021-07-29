public class Printer
{
    private String queue;
    private int allPrintingCountPage;
    private int pendingPagesCount;

    public void append(String text)
    {
        queue = queue + "Текст:" + text + "\n";
    }

    public void append(String text,String nameText)
    {
        queue = queue + "Текст:" + text + "\nНаименование:" +nameText + "\n";
    }

    public void append(String text,String nameText,int countPage)
    {
        queue = queue + "Текст: " + text + "\tНаименование: "+nameText + "\tСтраниц:" + countPage + "\n";
        pendingPagesCount = pendingPagesCount + countPage;
    }

    public int getPendingCountPages(){ return pendingPagesCount;}

    public int getAllCountPages()
    {
        return allPrintingCountPage;
    }

    public void print()
    {
        System.out.println ("\nПечатаем следующие документы :\n");
        System.out.println(queue);
        queue = "";
        allPrintingCountPage = allPrintingCountPage + pendingPagesCount;

        clear();
    }

    public void clear()
    {
        queue = "";
        pendingPagesCount = 0;
    }

}
