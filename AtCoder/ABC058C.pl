use strict;
use utf8;
use warnings;

sub mkcharcountarray{
    my $s = shift @_;
    my @counts = (0) x 26;
    foreach my $ac (split //, $s){
        my $inx = ord($ac) - 97;
        $counts[$inx] += 1;
    }
    \@counts;
}
chomp(my $n = <STDIN>);
chomp(my @lines = <STDIN>);
my @counts = ();
foreach (1..$n){
    push @counts, &mkcharcountarray($lines[$_ - 1]);
}
my @alphabets_count = (0) x 26;
foreach my $i(0..25){
    my $tmin = 51;
    foreach my $j(0..$n-1){
        my $t = $counts[$j][$i];
        if ($t < $tmin){
            $tmin = $t;
        }
    }
    @alphabets_count[$i] = $tmin;
}
my $ans = "";
foreach my $i(0..25){
    my $t = $i + 97;
    my $loop_cnt = $alphabets_count[$i];
    foreach my $j(0..$loop_cnt-1){
        my $ch = chr($t);
        $ans = $ans.$ch;
    }
}
print "$ans\n";
