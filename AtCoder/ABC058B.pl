use strict;
use utf8;
use warnings;

chomp(my @lines = <STDIN>);
my ($odd, $even) = @lines;
my @ans_list = ();
my @o_list = split(//, $odd);
my @e_list = split(//, $even);
foreach (1..$#e_list+1){
    push @ans_list, $o_list[$_-1];
    push @ans_list, $e_list[$_-1];
}
if ($#o_list != $#e_list){push @ans_list, $o_list[-1]}
my $ans = join("", @ans_list);
print "$ans\n";
