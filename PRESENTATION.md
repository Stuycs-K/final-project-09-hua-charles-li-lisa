# This document is required.

Matrix multiplication:
Show a 3x3 matrix times a 3x1 matrix to show how it works so its easier to show the hill cipher encode.

Hill cipher encode:
The Hill cipher generally only encodes the 26 letters of the English alphabet, which is what we have done for our project. That would make each letter correspond to a number modulo 26. For example, A would be 0, B would be 2, and Z would be 25. This however, can be changed depending on whatever set of characters you would like to be able to encrypt. This means that you can do upper and lower case, numbers, and special symbols, as long as you modulo each of them with the total number off characters that you'd like to encode.
To encrypt a message with the Hill cipher, there are two cases we will talk about.
First, for a message that is only n characters long, we just have to convert the key and the plaintext into a matrix (we are using double arrays). Then multiply the two, which will result in a final nx1. Modulo the whole matrix by 26, meaning each number will get modulo 26. Afterwards, just convert the numbers back to ASCII to get the cipher text.
Second, for a message longer than n characters, you'd want the length to be a multiple of n. This could mean tacking on an extra character (or two). Next, you split the message every n characters. For example, THISISAHILLL will be split like THI | SIS | AHI | LLL, if n is 3. This will make you a bunch off nx1 matrices. You then just repeat the process for the shorter message until all the shortened messages have been encrypted (multiplied and modulo 26). Finally, combine all the n length fragments to get your full cipher text.

key space size:
Explain CRT
Show the formula and show the number for 2x2 and 3x3 matrices.

demo:
Now, we'll show you a little bit of how our encode and decode works for 2x2 and 3x3 matrices. One thing to keep in mind is that the encode will always work, but the decode may not. This is because using our method of calculating the inverse matrix of the key, there isn't always an inverse matrix, meaning that the message can't be decoded.
Encode 2x2 short then decode.
Encode 3x3 short then decode.
Encode 2x2 long then decode.
Encode 3x3 long then decode.
Show a case where decode doesn't work due to no modular multiplicative inverse (which will probably be explained in the next Hill cipher video).
