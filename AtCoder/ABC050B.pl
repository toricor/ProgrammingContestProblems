use strict;
use utf8;
use warnings;

my $n = <STDIN>;
chomp($n);
my $tarr = <STDIN>;
chomp($tarr);
my @tarr = split(" ", $tarr);
my $m = <STDIN>;
chomp($m);
my $sum = 0;
foreach my $i (@tarr){
  $sum += $i;
}

for (my $c = 0; $c < $m; $c++){
  my $ans = $sum;
  my $px = <STDIN>;
  chomp($px);
  my @px = split(" ", $px);
  my $x = pop(@px);
  my $a = pop(@px);
  $ans -= $tarr[$a-1] - $x;
  print "$ans\n";
}
