use strict;
use warnings;
use utf8;

sub solve {
    my $mat = shift;
    
    my $calculated_direction   = decide_calc_direction($mat);
    my $possible_magic_squares = get_possible_magic_square($mat, $calculated_direction);
    return $possible_magic_squares;
}

sub get_possible_magic_square {
    my ($mat, $direction) = @_;
    my $n = scalar @$mat;
    my $ideal_row_sum = get_row_sum($mat);
    
    my $possible_matrixes = [];
    if ($direction eq 'h') {
        for my $row (@$mat) {
            my $zero_pos_num = $ideal_row_sum - sum($row);
            for (0..scalar(@$row)-1) {
                if ($$row[$_] == 0) {
                    $$row[$_] = $zero_pos_num;
                }
            }
            push(@$possible_matrixes, $row);
        }
    } else {
        $possible_matrixes = \@$mat;
        for my $x (0..$n-1) {
            for my $y (0..$n-1) {
                my $zero_pos_num = $ideal_row_sum - vertical_sum($mat, $x);
                if ($mat->[$y][$x] == 0) {
                    $possible_matrixes->[$y][$x] = $zero_pos_num;
                }
            }
        }
        
    }
    return $possible_matrixes;

}
sub vertical_sum {
    my $mat = shift;
    my $x   = shift;
    
    my $n = scalar @$mat;
    my $tot = 0;
    for my $y (0..$n-1) {
        $tot += $mat->[$y][$x];
    }
    return $tot;
}

# まず横向きに走査して見えないマスが2つとも同じ行にあったら"縦向き"と返す
sub decide_calc_direction {
    my $mat = shift;
    my $direction = 'h'; #horizontal or vertical
    for (@$mat) {
        my $cnt = count_zero($_);
        if ($cnt == 2) { $direction = 'v' }
    }
    return $direction;
}

sub sum {
    my $arr = shift;
    my $tot = 0;
    for (@$arr) {
        $tot += $_;
    }
    return $tot;
}

sub count_zero {
    my $arr = shift;
    my $cnt = 0;
    for (@$arr) {
        if ($_ == 0) { $cnt += 1 }
    }
    return $cnt;
}

sub is_contained_zero {
    my $arr = shift;
    for (@$arr) {
        if ($_ == 0) { return 1 }
    }
    return 0;
}

# 数字がそろっている部分をさがして合計値を返す
# 掛けている数字は2つだけなので縦か横を探せば十分
sub get_row_sum {
    my $mat = shift;
    my $n = scalar @$mat;
    my $tot = 0;
    for my $row (@$mat) {
        unless (is_contained_zero($row)) {
            $tot = sum($row);
            return $tot;
        }
    }
}

sub print_ans {
    my $ans = shift;
    for my $line (@$ans) {
        print "@$line\n";
    }
}

chomp(my $n = <>);
my $mat = [];
for (0..$n-1) {
    chomp(my $line = <>);
    my @row = split(/ /, $line);
    push(@$mat, \@row);
}
my $ans = solve($mat);
print_ans($ans);
