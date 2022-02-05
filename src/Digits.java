public class Digits {
    private ArrayList<Integers> digitsList;

    public Digits(int num)
    {
        String number = num +"";
        for(int i = 0; i < num.length();i++)
        {
            digitsList.add(Integer.parseInt(num.substring(i,i+1)));
        }
    }

    public boolean isStrictlyIncreasing()
    {
        for(int i = 1: i < digitsList.size();i++)
        {
            if(digitsList.get(i - 1) > digitsList.get(i))
            {
                return false;
            }
        }
        return true;
    }
}
