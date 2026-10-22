class Solution {
public:
    bool validateStackSequences(vector<int>& pushed, vector<int>& popped) {
        int n1 = pushed.size();
        int n2 = popped.size();
        stack<int>st;

        int i1 = 0,i2 = 0;
        while(i1<n1 && i2<n2)
        {
            if(pushed[i1]==popped[i2])
            {
                i1++;
                i2++;

                while(!st.empty() && st.top()==popped[i2])
                {
                    st.pop();
                    i2++;
                }
            }
            else st.push(pushed[i1++]);
        } 

        while(i1<n1) st.push(pushed[i1++]);
        
        while(i2<n2)
        {
            if(!st.empty() && st.top()==popped[i2]) st.pop();i2++;
        }

        return st.empty();
    }
};