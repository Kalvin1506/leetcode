class Solution {
public:
    int numDistinct(string txt, string pat) {
    int n1 = txt.size(),  n2 = pat.size();
    vector<int> dp(n2+1,0);
    dp[0] = 1;
    for(int i = 1;i<=n1;i++){
        for(int j =n2;j>=1;j--){
            if(txt[i-1]==pat[j-1]) {
                if(dp[j] > INT_MAX - dp[j-1]) dp[j] = INT_MAX;
                else dp[j] += dp[j-1];
            }
        }
    }
    return dp[n2];
}
};