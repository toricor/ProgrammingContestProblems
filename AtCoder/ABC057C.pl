use strict;
use utf8;
use warnings;

sub max{
    my($a, $b) = @_;
    if ($a > $b) {$a} else {$b}
}

chomp(my $n = <STDIN>);
my $i = 1;
my $min = 2**31-1;
while ($i <= sqrt($n)){
    if ($n%$i == 0){
        my $tmp_min = &max(length $i, length $n/$i);
        if ($tmp_min < $min){$min = $tmp_min}
    }
    $i++;
}
print "$min\n";
