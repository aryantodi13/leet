impl Solution {
    pub fn longest_common_prefix(strs: Vec<String>) -> String {
        let prefix = &strs[0];
//        let prefix_chars = prefix.chars();
        let mut index: usize = prefix.len();
        let mut j: usize = index;
        for i in strs.iter(){
            if i == prefix {
                continue;
            }
            else{
                if i.len() == 0{
                    return String::from("");
                }
                for (ind, ch) in i.chars().enumerate(){
                    j = ind;
                    if prefix.chars().nth(ind) == Some(ch) {
                        continue;
                    }
                    else{
                        if index > ind {
                            index = ind;
                        }
                        break;
                    }
                    println!("{ind} -> {ch} -> {:?}", (prefix.chars().nth(ind)) == Some(ch));
                }
                if index > j {
                    index = j + 1;
                }
            }
        }
        println!("{j}");
        return String::from(&prefix[..index]);
    }
}