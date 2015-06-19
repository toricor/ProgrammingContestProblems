def reverse_polish(operator):
    stack = []
    for i in range(len(operator)):
        if operator[i].isdigit(): # operand
            stack.append(float(operator[i]))
        elif operator[i] == '+':
            tmp = stack.pop()+stack.pop()
            stack.append(tmp)
        elif operator[i] == '-':
            tmp = -stack.pop() + stack.pop()
            stack.append(tmp)
        elif operator[i] == '*':
            tmp = stack.pop() * stack.pop()
            stack.append(tmp)
        elif operator[i] == '/':            
            tmp = (1./stack.pop())  *stack.pop()
            stack.append(tmp)
    print stack[0]

while True:
    try:
        operator = raw_input().split()
        reverse_polish(operator)
    except EOFError: 
        break
    
    
