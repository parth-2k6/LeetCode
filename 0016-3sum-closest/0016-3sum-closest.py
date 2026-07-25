class Solution(object):
    def threeSumClosest(self, nums, target):
        """
        :type nums: List[int]
        :type target: int
        :rtype: int
        """
        nums.sort()
        n = len(nums)
        diff = float('inf')
        sum = 0
        for i in range(n-2):
            left = i+1
            right = n-1
            while(left<right):
                total = nums[i]+nums[left]+nums[right]
                d = abs(target - total)
                if (d<diff):
                    diff = d
                    sum = total
                if (total == target):
                    return sum
                if (total < target):
                    left +=1
                else :
                    right -=1
        return sum