import tensorflow as tf
from tensorflow.examples.tutorials.mnist import input_data

# Dataset loading
mnist = input_data.read_data_sets("./samples/MNIST_data/", one_hot=True)

# Set up model
x = tf.placeholder(tf.float32, [None, 784])  #심볼릭 변수들을 사용하여 상호작
W = tf.Variable(tf.zeros([784, 10]))  #tf.Variable를 사용한 예제
b = tf.Variable(tf.zeros([10]))  #tf.Variable를 사용한 예제
y = tf.nn.softmax(tf.matmul(x, W) + b) #모델을 구현

y_ = tf.placeholder(tf.float32, [None, 10])  #정답을 입력하기 위한 새 placeholder를 추가

cross_entropy = -tf.reduce_sum(y_*tf.log(y))  #교차 엔트로피 −∑y′log(y) 를 구현
train_step = tf.train.GradientDescentOptimizer(0.01).minimize(cross_entropy) #비용 최소화에 어떤 변수가 얼마나 영향을 주는지를 계산

# Session
init = tf.initialize_all_variables()  #만든 변수들을 초기화하는 작업

sess = tf.Session()  #세션에서 모델을 시작하고 변수들을 초기화
sess.run(init)  #실행  

# Learning
for i in range(1000):  #우리는 학습을 100번 실행
  batch_xs, batch_ys = mnist.train.next_batch(100)
  sess.run(train_step, feed_dict={x: batch_xs, y_: batch_ys})

# Validation
correct_prediction = tf.equal(tf.argmax(y,1), tf.argmax(y_,1)) #특정한 축을 따라 가장 큰 원소의 색인을 알려준다
accuracy = tf.reduce_mean(tf.cast(correct_prediction, tf.float32))다 #얼마나 많은 비율로 맞았는지 확인

# Result should be approximately 91%.
print(sess.run(accuracy, feed_dict={x: mnist.test.images, y_: mnist.test.labels})) #테스트 데이터를 대상으로 정확도