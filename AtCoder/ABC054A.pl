use utf8;
use strict;
use feature qw(say);

chomp(my $line = <STDIN>);
my @ls = split " ", $line;
my @ref = qw/2 3 4 5 6 7 8 9 10 11 12 13 1/;
my ($a_inx) = grep { $ref[$_] == int $ls[0]} 0 .. $#ref;
my ($b_inx) = grep { $ref[$_] == int $ls[1]} 0 .. $#ref;
if ($a_inx > $b_inx){
    say "Alice\n";
}elsif($a_inx < $b_inx){
    say "Bob\n";
}else{
    say "Draw\n";
}
