use std::collections::HashSet;
impl Solution {   
    
    pub fn maximum_subarray_sum(nums: Vec<i32>, k: i32) -> i64 {
        let mut left = 0;
        let mut right = 0;
        let mut sum: i64 = 0;
        let mut max = 0;
        let mut val: HashSet<i32> = HashSet::new();
        while right < nums.len() {
            let num = nums.get(right).unwrap();
            if(val.contains(num)){
                //Duplicate value
                while true {
                    let leftVal = nums.get(left).unwrap();
                    val.remove(leftVal);
                    sum -= *leftVal as i64;
                    left += 1;
                    if(leftVal == num){
                        break;
                    }
                }
            }
            else {
                val.insert(*num);
                sum += *num as i64;
                right+=1;
                if(right - left == k as usize){
                    max = if sum > max { sum } else { max };
                    sum -= *nums.get(left).unwrap() as i64;
                    val.remove(nums.get(left).unwrap());
                    left += 1;
                }
            }
        }
        return max;
    }

}