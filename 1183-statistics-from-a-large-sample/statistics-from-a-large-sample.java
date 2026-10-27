class Solution {
    public double[] sampleStats(int[] count) {
        double res[]=new double[5];
        for(int i=0;i<256;i++)
        {
            if(count[i]!=0)
            {
                res[0]=(double)i;
                break;
            }
        }
        for(int i=255;i>=0;i--)
        {
            if(count[i]!=0)
            {
                res[1]=(double)i;
                break;
            }
        }
        long sum=0;
        long total=0;
        for(int i=0;i<256;i++)
        {
            sum+=(long)i*count[i];
            total+=count[i];
        }
        res[2]=(double)sum/total;
        long pos1 = (total+1)/2;
        long pos2 = (total+2)/2;
        long median1=0;
        long median2=0;
        long cur=0;
        for(int i=0;i<256;i++)
        {
            cur+=count[i];
            if(median1==0 && cur>=pos1)
            {
                median1 = i;
            }
            if(cur>=pos2)
            {
                median2=i;
                break;
            }
        }
        res[3]=(median1+median2)/2.0;
        int maxi = 0;
        for(int i=0;i<256;i++)
        {
            if(count[i]>maxi)
            {
                maxi = count[i];
                res[4]=(double)i;
            }
        }
        return res;
    }
}