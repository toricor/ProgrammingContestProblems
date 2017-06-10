use strict;
use utf8;
use warnings;

sub count_colors {
    my $inx_array = shift; # [ 0, 4, 3, 8, ...]
    my @count_array = (0, 0, 0, 0, 0, 0, 0, 0);
    for my $x (@$inx_array){
        $count_array[$x]++;
    }

    return \@count_array;
}

sub make_rank_array {
    my $arr = shift;
    my @uppers = (399, 799, 1199, 1599, 1999, 2399, 2799, 3199);
    my @ret = ();
    for my $point (@$arr){
        if ($point <= 399){
            push(@ret, 0);
            next;
        }
        if (3199 < $point){
            push(@ret, 8);
            next;
        }
        for my $inx (1..$#uppers-1){
            if ($uppers[$inx] < $point && $point <= $uppers[$inx+1]){
                push(@ret, $inx);
                last;
            }
        }
    }

    return \@ret;
}

sub calc_min_color_count {
    my $count_array = shift;  # [1 0 0 0 0 0 0 0 2];
    my $ret;
    for (0..7){
        if ($$count_array[$_]){
            $ret++;
        }
    }
    return $ret;
}

sub _max {
    my ($a, $b) = @_;
    my $ret = $a < $b ? $b : $a;
    return $ret;
}

sub _min {
    my ($a, $b) = @_;
    my $ret = $a < $b ? $a : $b;
    return $ret;
}

sub calc_max_color_count {
    my $count_array  = shift;  # [0 2 0 0 0 0 0 0 3];
    my $master_count = $$count_array[8];# member over 3200
    my $true_count = 0;
    my $zero_count = 0;
    for (0..7){
       print "$$count_array[$_]";
        if ($$count_array[$_] != 0){
            $true_count++;
        }else{    
            $zero_count++;
        }
    }
    return $true_count + _min($zero_count, $master_count);
}

sub main {
    my $n = <STDIN>;
    chomp($n);
    my $line = <STDIN>;
    chomp($line);
    my @a = split(/ /, $line);

    my $color_count_list = make_rank_array(\@a);
    my $ls = count_colors($color_count_list);
    my $minval = calc_min_color_count($ls) || 1;
    my $maxval = calc_max_color_count($ls) || 1;
    my @ans = ($minval, $maxval);
    print "@ans\n";
}

main;
