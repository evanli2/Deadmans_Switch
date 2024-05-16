# LiskGuardian
Decentralized, trustless, and anonymous crypto wills. A switch that triggers at death. User activity resets the countdown. 
Built on the Lisk L2 Blockchain.

Try it out:

https://www.dropbox.com/scl/fi/l9xj9sbrxmouxjsctb2hj/liskguardian.apk?rlkey=ri9pnytbl81ji8ke004bk7so1&st=gnt62si1&dl=0

https://www.youtube.com/watch?v=vR62LbLSrGg

# Inspiration
The app was inspired by the need for a more secure and transparent way of managing digital assets after death. While some may opt for a lawyer to handle their will and distribute their crypto assets, there are inherent risks in entrusting private keys to a third party. In the event of a security breach, the private keys could be compromised,
putting the entire estate at risk. Our solution is decentralized and trustless, ensuring that the wishes of the deceased are executed without any reliance on a single individual or institution.

# Built with

Lisk Guardian is developed natively on Android utilizing Java. The smart contract is written in Solidity. To ensure secure communications, messages are AES encrypted on-chain. For the generation of the decryption key, we employ the built-in mnemonic utilities of the web3j library.

The app uses:

- The Web3j Ethereum library
- MVVM Clean Architecture 
- RxJava
- Room
- Dagger Hilt

The contracts are deployed on the Lisk L2 Testnet

https://sepolia-blockscout.lisk.com/address/0xb794718E7d489fd8d40985B43a49bbe15FC1267f
