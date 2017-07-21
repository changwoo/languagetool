/* LanguageTool, a natural language style checker 
 * Copyright (C) 2006 Daniel Naber (http://www.danielnaber.de)
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA  02110-1301
 * USA
 */
package org.languagetool.tokenizers.ko;

import org.junit.Test;
import org.languagetool.TestTools;
import org.languagetool.language.Korean;
import org.languagetool.tokenizers.SRXSentenceTokenizer;

public class KoreanSRXSentenceTokenizerTest {

  private final SRXSentenceTokenizer stokenizer = new SRXSentenceTokenizer(new Korean());

  @Test
  public void testTokenize() {
    // NOTE: sentences here need to end with a space character so they
    // have correct whitespace when appended:
    testSplit("이 문장은 하나의 문장입니다.");
    testSplit("첫 문장입니다. ", "그리고 두번째 문장입니다.");
    testSplit("\"따옴표 포함해서 한 문장입니다.\" ", "다음 문장입니다.");
    testSplit("1.가. 이렇게 번호 매기기에 사용하는 마침표는 문장을 나누지 않습니다.");
    testSplit("이렇게 http://www.test.ko URL은 하나의 문장입니다.");
    testSplit("이렇게 써도 (?) 하나의 (!) 문장(...)입니다.");
    testSplit("물론 이렇게... ", "쓰면 두 문장이고요.");
  }

  private void testSplit(String... sentences) {
    TestTools.testSplit(sentences, stokenizer);
  }
}
