[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/ecp4su41)
# THIS DOCUMENT IS REQUIRED
## Presentation Info
https://drive.google.com/file/d/1-8-W6wNiL9XmoZOU_Qm2HcP0eVuFztsg/view?usp=sharing 

## Overview
Our project is an encryption/decryption tool that utilises linear algebra (matrices). The pen-and-paper cipher is called the Hill cipher, which is a polygraphic substitution cipher. The encryption method uses matrix multiplication to encrypt a message using a n x n matrix known as the key. The decryption method uses the inverse matrix to decrypt a cipher text using a known n x n key. In our case, we've completed both methods for 2 x 2 and 3 x 3 matrices, though some text cannot be decrypted using this method.

## Instructions
For encode mode, provide the plaintext and keytext in separate files, all capitalized, no spaces. For decode mode, provide the ciphertext and keytext in separate files, all capitalized, no spaces. To run, type in the command prompt: make encode/decode ARGS="plain.txt/cipher.txt key.txt", which will either encode or try to decode the message.
