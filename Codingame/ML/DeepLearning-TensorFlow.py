# MNIST For ML Beginners!

# This tutorial is intended for readers who are new to both machine learning and TensorFlow.
# Just like programming has Hello World, machine learning has MNIST.
# MNIST is a simple computer vision dataset. It consists of images of handwritten digits.
# Source: https://goo.gl/B14py7

# Please help us to improve this section by sending us your
# feedbacks and comments on: https://docs.google.com/forms/d/16fH20Qf8gJ2o31Vnlss2uLJ7wL9vq76TeUGqghTY0uI/viewform

# Importing input data
import random
import input_data
import numpy as np
#import scipy as sp
mnist = input_data.read_data_sets(raw_input(), raw_input(), raw_input())

import tensorflow as tf
################################
# Enter your code between here #
################################
x = tf.placeholder("float", [None, 784])
W = tf.Variable(tf.zeros([784,10]))
b = tf.Variable(tf.zeros([10]))
y = tf.nn.softmax(tf.matmul(x,W) + b)
y_ = tf.placeholder("float", [None,10])
cross_entropy = tf.reduce_mean(-tf.reduce_sum(y_ * tf.log(y), reduction_indices=[1]))
train_step = tf.train.GradientDescentOptimizer(0.5).minimize(cross_entropy)
init = tf.initialize_all_variables()
sess = tf.Session()
sess.run(init)
for i in range(1000):
    batch_xs, batch_ys = mnist.train.next_batch(100)
    

#print ' '.join(map(str, [random.randint(0,9) for _ in range(len(mnist.validation.images))]))


########################
#        And here      #
########################


# Uncomment to get a prediction number for each image

result = sess.run(tf.argmax(y,1), feed_dict={x: mnist.validation.images})
print ' '.join(map(str, result))
