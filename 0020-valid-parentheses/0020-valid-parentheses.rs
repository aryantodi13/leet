use std::vec::Vec;
impl Solution {
    pub fn is_valid(s: String) -> bool {
        let mut stack:Vec<char> = Vec::new();
        for c in s.chars(){
            if c == '{' {
                stack.push('}');
            }
            else if c == '(' {
                stack.push(')');
            }
            else if c == '[' {
                stack.push(']');
            }
            else {
                if stack.len() == 0 { return false; }
                if stack.pop() != Some(c) { return false; }
            }
        }
            return stack.len() == 0;
    }
}