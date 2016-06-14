package edu.ufmg.dcc849.util;

/**
 * Created by Vinicius on 10/06/2016.
 */
public class Statistics {
    private Double[] data;
    private int size;

    public Statistics(Double[] data){
        this.data = data;
        this.size = data.length;
    }

    public Double getMean(){
        Double sum = 0.0;
        for(Double a : this.data)
            sum += a;
        return sum/this.size;
    }

    public Double getVariance(){
        Double mean = getMean();
        Double temp = 0.0;
        for(Double a : this.data)
            temp += (mean-a)*(mean-a);
        return temp/(this.size-1);
    }

    public Double getStdDev(){
        return Math.sqrt(getVariance());
    }

    public Double getConfidenceInterval(Double tValue){
        return tValue*(getStdDev()/Math.sqrt(this.size));
    }
}
