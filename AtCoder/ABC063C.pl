use utf8;
use warnings;
use strict;
use List::Util qw/sum/;

chomp(my $n = <STDIN>);
my @arr = ();
for my $i (<STDIN>){
    chomp($i);
    push(@arr, $i)
}
@arr = sort {$a <=> $b} @arr;
my $tot = sum @arr;
$tot%10 == 0? print del_minimum_number_not_divided_by_ten(\@arr) : print $tot;

sub del_minimum_number_not_divided_by_ten {
    my $arr = shift;
    for my $i (0..scalar(@$arr)-1) {
        if ($arr[$i]%10 == 0) {
            next
        } else {
            $arr[$i] = 0;
            if (sum(@$arr)%10 == 0) {
                return del_minimum_number_not_divided_by_ten($arr);
            } else {
                return sum(@$arr);
            }
        }
    }
    return 0;
}
