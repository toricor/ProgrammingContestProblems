use strict;
use warnings;
#use diagnostics;
use 5.20.1;

select(STDOUT); $| = 1; # DO NOT REMOVE

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.
# ---
# Hint: You can use the debug stream to print initialTX and initialTY, if Thor seems not follow your orders.

my $tokens;

# light_x: the X position of the light of power
# light_y: the Y position of the light of power
# initial_tx: Thor's starting X position
# initial_ty: Thor's starting Y position
chomp($tokens=<STDIN>);
my ($light_x, $light_y, $initial_tx, $initial_ty) = split(/ /,$tokens);

# game loop
my $current_x = $initial_tx;
my $current_y = $initial_ty;
while (1) {
    chomp(my $remaining_turns = <STDIN>); # The remaining amount of turns Thor can move. Do not remove this line.
    my $ans = "";
    # Write an action using print
    # To debug: print STDERR "Debug messages...\n";
    if ($light_y - $current_y > 0) {
        $ans .= "S";
        $current_y += 1;
    }elsif ($light_y - $current_y < 0) {
        $ans .= "N";
        $current_y -= 1;
    }
    if ($light_x - $current_x > 0) {
        $ans .= "E";
        $current_x  += 1;
    }elsif ($light_x - $current_x < 0) {
        $ans .= "W";
        $current_x  -= 1;
    }
    
    # A single line providing the move to be made: N NE E SE S SW W or NW
    print STDERR "$current_x $current_y\n";
    print "$ans\n";
}
