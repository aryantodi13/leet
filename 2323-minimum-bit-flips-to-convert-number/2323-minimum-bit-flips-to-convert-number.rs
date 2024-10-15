impl Solution {
    pub fn min_bit_flips(start: i32, goal: i32) -> i32 {
        let mut x = start ^ goal;
        let mut count = 0;
        while x > 0 {
            count += x % 2;
            x = x/2;
        }
        return count;
    }
}