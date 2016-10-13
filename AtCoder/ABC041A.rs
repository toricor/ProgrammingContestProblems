use std::io;
use std::cmp::Ordering;

pub fn main() {
    let mut st = String::new();
    io::stdin().read_line(&mut st)
        .expect("Falied to read line1");
    let st = st.trim();

    let mut inx = String::new();
    io::stdin().read_line(&mut inx)
        .expect("Falied to read line2");
    let inx = inx.trim().parse() // shadowing
        .expect("Please type a number!");
    for (i, ch) in st.chars().enumerate() {
        match (i+1).cmp(&inx) {
            Ordering::Greater => {}
            Ordering::Equal => {println!("{}", ch); break;}
            Ordering::Less => {}
        }
    }
}
