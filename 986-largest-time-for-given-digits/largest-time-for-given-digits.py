class Solution(object):
    def largestTimeFromDigits(self, arr):
        # s=""
        # arr1=arr[:]
        # for x in range(2,-1,-1):
        #     if x in arr:
        #         s+=str(x)
        #         arr.remove(x)
        #         break
        # if len(s)>0 and s[0]=="2":
        #     for x in range(3,-1,-1):
        #         if x in arr:
        #             s+=str(x)+":"
        #             arr.remove(x)
        #             break
        # if len(s)>2:
        #     for x in range(5,-1,-1):
        #         if x in arr:
        #             s+=str(x)
        #             arr.remove(x)
        #             break
        # if len(s)>3:
        #     for x in range(9,-1,-1):
        #         if x in arr:
        #             s+=str(x)
        #             break
        # if len(s)==5:
        #     return s
        # a=""
        # for x in range(1,-1,-1):
        #     if x in arr1:
        #         a+=str(x)
        #         arr1.remove(x)
        #         break
        # if len(a)>0 and a[0] in "01":
        #     for x in range(9,-1,-1):
        #         if x in arr1:
        #             a+=str(x)+":"
        #             arr1.remove(x)
        #             break
        # if len(a)>2:
        #     for x in range(5,-1,-1):
        #         if x in arr1:
        #             a+=str(x)
        #             arr1.remove(x)
        #             break
        # if len(a)>3:
        #     for x in range(9,-1,-1):
        #         if x in arr1:
        #             a+=str(x)
        #             break
        # return a if len(a)==5 else ""
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