model = Sequential([
    Dense(100, input_dim=INPUTDIM),
    Activation('linear'),
    Dense(50),
    Activation('linear'),
    Dense(10),
    Activation('linear'),
    Dense(2),
    Activation('linear'),
])

model.compile(optimizer='rmsprop', loss='mse')

model.fit(np.array(trainingFeatures), np.array(trainingTargets), epochs=1000, batch_size=32000)

np.set_printoptions(threshold=sys.maxsize)

print("PREDICTIONS START")

print(model.predict(np.array(predictionFeatures), batch_size=32))
