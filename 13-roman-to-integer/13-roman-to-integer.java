class Solution {
    public int romanToInt(String s) {
        int result = 0;
        
        int ptr = 0;
        while (ptr < s.length() - 1) {
            char symbol = s.charAt(ptr);
            char nextSymbol = s.charAt(ptr + 1);
            if (isSubtractableCharacter(symbol, nextSymbol)) {
                result += getRomanSubtraction(symbol, nextSymbol);
                ptr++;
            } else {
                result += getRomanValue(symbol);
            }
            ptr++;
        }
        
        if (ptr < s.length()) {
            result += getRomanValue(s.charAt(ptr));
        }
        
        return result;
    }
    
    private int getRomanValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
    
    private boolean isSubtractableCharacter(char c1, char c2) {
        if (c1 == 'I') {
            return c2 == 'V' || c2 == 'X';
        } else if (c1 == 'X') {
            return c2 == 'L' || c2 == 'C';
        } else if (c1 == 'C') {
            return c2 == 'D' || c2 == 'M';
        }
        
        return false;
    }
    
    private int getRomanSubtraction(char c1, char c2) {
        if (c1 == 'I') {
            if (c2 == 'V') {
                return 4;
            } else if (c2 == 'X') {
                return 9;
            }
        } else if (c1 == 'X') {
            if (c2 == 'L') {
                return 40;
            } else if (c2 == 'C') {
                return 90;
            }
        } else if (c1 == 'C') {
            if (c2 == 'D') {
                return 400;
            } else if (c2 == 'M') {
                return 900;
            }
        }
        
        return 0;
    }
}
