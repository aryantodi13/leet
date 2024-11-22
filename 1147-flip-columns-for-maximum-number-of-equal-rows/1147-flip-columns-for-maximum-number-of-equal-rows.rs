use std::collections::HashMap;
impl Solution {
    fn invert(str: String)-> String{
        let mut s = String::new();
        for i in str.chars(){
            let ch = if i == '0' { '1' } else { '0' };
            s.push(ch);
        }
        return s;
    }

        fn max_equal_rows_after_flips(matrix: Vec<Vec<i32>>) -> i32{
        let mut mp: HashMap<String, i32> = HashMap::new();
        let mut max = 1;
        for i in matrix{
            let mut s = String::new();
            for j in i{
                s.push_str(&j.to_string());
            }
            let f = s.chars().nth(0).unwrap();
            s = if f == '1' { Self::invert(s) } else { s };
            if(mp.contains_key(&s)){
                let mut count = *mp.get(&s).unwrap();
                count = count + 1;
                mp.insert(s, count);
                max = if max < count { count } else {max};
            }
            else {
                mp.insert(s, 1);
            }
        }
        return max;
    }
}