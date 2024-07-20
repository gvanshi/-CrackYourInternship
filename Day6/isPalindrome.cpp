static const int _ = []() {
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    return 0;
}();

class Solution {
private:
    bool isPalindrome(string s) {
        int size = s.size(), l = 0, r = size - 1;
        while (l < r) {
            if (s[l] == s[r]) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }

public:
    bool validPalindrome(string s) {
        int size = s.size(), l = 0, r = size - 1;
        while (l < r) {
            if (s[l] == s[r]) {
                l++;
                r--;
            } else if (s[l] == s[r - 1]) {
                std::string temp(s.begin() + l, s.end() - l - 1);
                if (isPalindrome(temp)) {
                    return true;
                } else {
                    std::string temp2(s.begin() + l + 1, s.end() - l);
                    if (isPalindrome(temp2)) {
                        return true;
                    }
                    return false;
                }
            } else if (s[l + 1] == s[r]) {
                std::string temp(s.begin() + l + 1, s.end() - l);
                if (isPalindrome(temp)) {
                    return true;
                } else {
                    std::string temp2(s.begin() + l, s.end() - l - 1);
                    if (isPalindrome(temp2)) {
                        return true;
                    }
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }
};
