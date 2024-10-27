# Triangle

[![LICENSE CC0-1.0](https://img.shields.io/badge/LICENSE-CC0--1.0-blue)](https://github.com/tamada/triangle/blob/main/LICENSE)
![Version Info](https://img.shields.io/badge/Version-1.0.0-blue)

## :speaking_head: Overview

三角形を材料として，オブジェクト指向のカプセル化を学ぶためのプロジェクトです．

### メソッド

getter/setter は必要ないということを表すため，種々のメソッドを提供します．

- `isEquilateral()`: この三角形が正三角形であるかどうかを判定します．
- `isRight()`: この三角形が直角三角形であるかどうかを判定します．
- `isObtuse()`: この三角形が鈍角三角形であるかどかを判定します．
- `isAcute()`: この三角形が鋭角三角形であるかどうかを判定します．
- `isIsosceles()`: この三角形が二等辺三角形であるかどうかを判定します．
- `isScalene()`: この三角形が不等辺三角形であるかどうかを判定します．

`Triangle` は，上記メソッドを提供します．
その代わりに，判定アルゴリズムを内部に持つことになり，クラスの肥大化につながります．

`Triangle2` は判定アルゴリズムを `Triangle2Utils` に分離させ，`Triangle2` はフィールドのみを持つようにしています．
一方，`Triangle2Utils`からは，直接フィールドにアクセスできません．
そのため，`Visitor` パターンを利用して，`Triangle2` のフィールドにアクセスします．
これにより，必要なフィールドのみを必要なときに取得できるようになります．

