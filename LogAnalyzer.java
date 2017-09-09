/**
 * Read web server data and analyse
 * hourly access patterns.
 * 
 * @author David J. Barnes and Michael Kolling.
 * @version 2008.03.30
 */
public class LogAnalyzer
{
    // Where to calculate the hourly access counts.
    private int[] hourCounts;
    // Use a LogfileReader to access the data.
    private LogfileReader reader;

    /**
     * Create an object to analyze hourly web accesses.
     */
    public LogAnalyzer()
    { 
        // Create the array object to hold the hourly
        // access counts.
        hourCounts = new int[24];
        // Create the reader to obtain the data.
        reader = new LogfileReader();
    }

    /**
     * Analyze the hourly access data from the log file.
     */
    public void analyzeHourlyData()
    {
        while(reader.hasMoreEntries()) {
            LogEntry entry = reader.nextEntry();
            int hour = entry.getHour();
            hourCounts[hour]++;
        }
    }

    /**
     * Print the hourly counts.
     * These should have been set with a prior
     * call to analyzeHourlyData.
     */
    public void printHourlyCounts()
    {
        System.out.println("Hr: Count");
        for(int hour = 0; hour < hourCounts.length; hour++) {
            System.out.println(hour + ": " + hourCounts[hour]);
        }
    }

    /**
     * Print the lines of data read by the LogfileReader
     */
    public void printData()
    {
        reader.printData();
    }

    /**
     * Retorna o número de acessos registrados no arquivo
     * de log.
     */
    public int numberOfAccesses()
    {
        int total = 0;
        // adiciona o valor em cada elemento de hourCounts
        // ao total.
        for (int i = 0; i < hourCounts.length; i++) {
            total += hourCounts[i];
        } 
        
        return total;
    }
    
    public int busiestHour()
    {
        int busiestHour = 0; // qual a hora mais ocupada?
        int accessCount = 0; // quantos acessos a hora mais ocupada tem?
        for (int hour = 0; hour < hourCounts.length; hour++) {
            if (hourCounts[hour] > accessCount) {
                busiestHour = hour;
                accessCount = hourCounts[hour];
            }
        }
        
        return busiestHour;
    }
    
    public int quietestHour()
    {
        int quietestHour = 0;
        int hour = 0;
        int accessCount = hourCounts[hour++]; // atribui o valor de hourCounts[0]
        // a count e incrementa hour
        while (hour < hourCounts.length) {
            if (hourCounts[hour] < accessCount) {
                quietestHour = hour;
                accessCount = hourCounts[hour];
            }
            hour++;
        }
        
        return quietestHour;
    }
    
    public int busiestTwoHours () {
        int accessCount = 0;
        int busiestFirstHour = 0;
        for (int hour = 0; hour < hourCounts.length; hour += 2) {
            int currCount = hourCounts[hour] + hourCounts[hour+1];
            if (currCount > accessCount) {
                busiestFirstHour = hour;
                accessCount = currCount;
            }
        }
        
        return busiestFirstHour;
    }
}
