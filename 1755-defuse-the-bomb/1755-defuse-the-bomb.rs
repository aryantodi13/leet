impl Solution {
        pub fn decrypt(code: Vec<i32>, k: i32) -> Vec<i32> {
        let mut ccl = code.clone();
        if(k == 0){
            for i in ccl.iter_mut(){
                *i = 0;
            }
        }
        else if (k > 0){
            let mut sum = 0;
            let ku: usize = k as usize + 1usize;
            let mut ku2: usize;
            for i in  1usize..ku{
                let val= ccl.get(i);
                let value: i32;
                if(!val.is_none()){
                    value = *val.unwrap();
                    sum += value;
                }
            }
            for (i, j) in ccl.iter_mut().enumerate(){
                *j = sum;
                let index= if i + ku < code.len() { i + ku } else {i + ku - code.len()};
                ku2 = if i + 1 == code.len() { 0 } else {i + 1};
                //print!("{}", index);
                let val = code.get(index);
                sum -= code.get(ku2).unwrap();
                sum += val.unwrap();
            }
        }
        else if (k < 0){
            let mut sum = 0;
            let mut ku = code.len()  + k as usize;
            for i in ku..code.len(){
                sum += *ccl.get(i).unwrap();
            }
            for (i, j) in ccl.iter_mut().enumerate(){
                *j = sum;
                sum -= *code.get(ku).unwrap();
                sum += *code.get(i).unwrap();
                ku = if ku == code.len() - 1 { 0 } else { ku + 1 };
            }
        }
        return ccl;
    }
}