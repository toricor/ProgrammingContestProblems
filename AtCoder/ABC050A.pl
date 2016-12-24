use strict;
use utf8;
use warnings;
 
my $inp = <STDIN>;
chomp($inp);
my @segments = split(" ", $inp);
my $tail = pop(@segments);
my $ op  = pop(@segments);
my $head = pop(@segments);
my $ans;
if ($op eq "+"){
    $ans = $head + $tail;
}else{
    $ans = $head - $tail;
}
print "$ans\n";
