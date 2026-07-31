class Solution:
    def largeGroupPositions(self, s: str) -> List[List[int]]:
        a = 0
        b = 1
        L = []
        count = 0
        while a < len(s) and b < len(s):
            if s[a] == s[b]:
                count += 1
                b += 1
            else:
                print(count)
                if count >= 2:
                    L.append([a, b-1])
                a = b
                b = b + 1
                count = 0 
        if count >= 2:
            L.append([a, b-1])

        return L

                
        
        