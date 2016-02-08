import sys
import math

# Auto-generated code below aims at helping you parse
# the standard input according to the problem statement.
def main():
    n = int(raw_input())  # Number of elements which make up the association table.
    q = int(raw_input())  # Number Q of file names to be analyzed.
    dic = {}
    for i in xrange(n):
        # ext: file extension
        # mt: MIME type.
        ext, mt = raw_input().split()
        dic[ext.lower()] = mt
    
    for i in xrange(q):
        fname = raw_input()  # One file name per line.
        #print >> sys.stderr, "Debug messages...",  n,q,fname
        if not "." in fname:
            print "UNKNOWN"
            continue
        fname_ext = fname.split(".")[-1].lower()
        if not dic.has_key(fname_ext):
            print "UNKNOWN"
            continue
        else:
            print dic[fname_ext]

    # Write an action using print
    # To debug: print >> sys.stderr, "Debug messages..."
    
    # For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    
main()
