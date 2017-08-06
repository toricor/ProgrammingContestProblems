use strict;
use warnings;
use utf8;

sub solve {
    my $inp = shift;
    
    my $pre_ch = 'b';
    my $bcount = 0;
    my $wcount = 1;
    my @ans = ();
    for my $ch (split(//, $inp)) {
        unless ($ch eq $pre_ch) {
            if ($pre_ch eq 'b') {
                push(@ans, $bcount);
                $bcount = 1;
            } else {
                push(@ans, $wcount);
                $wcount = 1;
            }
        } else {
            if ($pre_ch eq 'b') {
                $bcount += 1;
            } else {
                $wcount += 1;
            }
        }
        $pre_ch = $ch;
    }
    if ($pre_ch eq 'b') {
        push(@ans, $bcount);
    } else {
        push(@ans, $wcount);
    }
    return @ans;
}

chomp(my $inp = <>);
my $init = (split(//, $inp))[0];
my @ans = solve($inp);
print "@ans\n"
