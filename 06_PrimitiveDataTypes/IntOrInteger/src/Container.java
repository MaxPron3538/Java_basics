public class Container
{
    private Integer count;

    Container(int count)
    {
        this.count = count;
    }

    public void addCount(int value) {
        count = count + value;
    }

    public int getCount() {
        return count;
    }
}
