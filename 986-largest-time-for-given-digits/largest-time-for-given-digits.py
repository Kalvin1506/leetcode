class Solution(object):
    def largestTimeFromDigits(self, arr):
       
        s=""
        arr1=arr[:]

        def check(a,nums,s):
            for x in range(a,-1,-1):
                if x in nums:
                    s+=str(x)
                    nums.remove(x)
                    break
            return s

        s=check(2,arr,s)
        if len(s)>0 and s[0]=="2":
            s=check(3,arr,s)+":"
        if len(s)>2:
            s=check(5,arr,s)
        if len(s)>3:
            s=check(9,arr,s)
        if len(s)==5:
            return s

        s=""
        s=check(1,arr1,s)
        if len(s)>0 and s[0] in "01":
            s=check(9,arr1,s)+":"
        if len(s)>2:
            s=check(5,arr1,s)
        if len(s)>3:
            s=check(9,arr1,s)

        return s if len(s)==5 else ""