use std::collections::HashSet;
impl Solution {
    pub fn count_consistent_strings(allowed: String, words: Vec<String>) -> i32 {
        let mut ch = HashSet::new();
        let mut count = 0;
        for x in allowed.chars() {
            ch.insert(x);
        }
        'outer: for i in 0..words.len() {
            let word = &words[i];
            for c in word.chars() {
                if  !ch.contains(&c) {
                    continue 'outer;
                }
            }
            count += 1;
            // println!("{}", word);
        }
        return count;
    }
}