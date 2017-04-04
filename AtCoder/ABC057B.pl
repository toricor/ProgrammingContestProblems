use warnings;
use strict;
use utf8;

chomp(my $line = <STDIN>);
my($n, $m) = split / /, $line;
chomp(my @students = <STDIN>);
my @points = splice @students, $n;

foreach my $s (1..$n){
    my $ans = 1;
    my $min_dist = 2**31 - 1;
    foreach my $p (1..$m){
        my ($sx, $sy) = split / /, $students[$s - 1];
        my ($px, $py) = split / /, $points[$p - 1];
        my $dist = abs($sx - $px) + abs($sy - $py);
        if ($dist < $min_dist){
            $min_dist = $dist;
            $ans = $p;
        }
    }
    print "$ans\n"
}
