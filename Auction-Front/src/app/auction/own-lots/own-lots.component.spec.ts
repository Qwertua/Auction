import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OwnLotsComponent } from './own-lots.component';

describe('OwnLotsComponent', () => {
  let component: OwnLotsComponent;
  let fixture: ComponentFixture<OwnLotsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OwnLotsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(OwnLotsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
