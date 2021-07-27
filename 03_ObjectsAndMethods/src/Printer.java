public class Printer
{
    String queue;
    int generalPrintedNumber;

    String append(String text){ return queue += text; }

    String append(String text,String nameText) { return queue += append(text)  + "\n" + "name: " + nameText; }

    String append(String text,String nameText,int numberOfPages)
    {
        getPendingPagesCount(numberOfPages);
        getPrintedPagesCount(numberOfPages);

        return queue += append(text,nameText) + "number of pages: " + numberOfPages;
    }

    int getPendingPagesCount(int addedGeneralNumber){ return addedGeneralNumber;}

    int getPrintedPagesCount(int printedNumberOfPages)
    {
        return generalPrintedNumber += printedNumberOfPages;
    }

    void print(String text,String nameText,int numberOfPages)
    {
        if(nameText != "" & numberOfPages != 0) append(text,nameText,numberOfPages);

        else if(nameText != "" & numberOfPages <= 0) append(text,nameText);

        else append(text);

        clear();
    }

    void clear() { queue = ""; }

}
